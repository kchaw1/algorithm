package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 문제
 * 언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다.
 * 인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다.
 * 최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.
 *
 * 그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중
 * 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다.
 * 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
 *
 * 이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.
 */
public class Q1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseSize = Integer.parseInt(br.readLine()); // 테스트 케이스

        int[] result = new int[testCaseSize]; // 정답배열

        for (int i = 0; i < testCaseSize; i++) {
            int applicantCount = Integer.parseInt(br.readLine()); // 지원자수
            int[][] scores = new int[applicantCount][2]; // 지원자 점수 배열

            for (int j = 0; j < applicantCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                scores[j][0] = Integer.parseInt(st.nextToken()); // 지원자 서류성적
                scores[j][1] = Integer.parseInt(st.nextToken()); // 지원자 면접 성적
            }

            int passable = applicantCount; // 통과가능한 지원자수 (초기값 : 지원자수전체수)
            
           /* for (int j = 0; j < scores.length; j++) {
                for (int k = 0; k < scores.length; k++) {
                    if(i==k) continue;

                    if(scores[j][0] > scores[k][0]
                        && scores[j][1] > scores[k][1]) { // 자신보다 서류 및 면접 성적이 둘다 높은 지원자가 존재할 경우
                        passable--; // 통과가능한 지원자수에서 제외
                        break;
                    }
                }
            } */ // 시간초과 코드

            Arrays.sort(scores, new Comparator<int[]>() { // 서류 오름차순 정렬
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int prevInterviewScore = scores[0][1];
            for (int j = 1; j < scores.length; j++) { // 첫번째는 1등이니 통과
                if(prevInterviewScore < scores[j][1]) {
                    passable--;
                } else {
                    prevInterviewScore = scores[j][1];
                }
            }

            result[i] = passable; // 정답 배열에 합격자수 입력
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]); // 최종합격가능한 수 출력
        }

        br.close();
    }
}
