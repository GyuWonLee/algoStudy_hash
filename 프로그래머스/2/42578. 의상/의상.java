// 이 문제는 해시맵을 활용하여 의상의 종류별 개수를 세고,
// 각 종류마다 "입는 경우 + 입지 않는 경우"를 곱해서 전체 경우의 수를 구하는 문제

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        
        // 종류별 옷 개수를 저장 (Key: 의상 종류, Value: 개수)
        HashMap<String, Integer> map = new HashMap<>();
        
        // clothes 배열을 돌면서 종류별 개수를 센다
        for (String[] cloth : clothes) {
            String category = cloth[1];
            
            // getOrDefault(category, 0)
            // category가 이미 있으면 기존 값 반환
            // 없으면 0 반환 (처음 등장한 경우)
            
            // 해당 종류의 옷 개수를 1 증가는 +1
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        // 전체 경우의 수 계산
        // 각 종류마다 (입는 경우 + 안 입는 경우)를 고려해서 곱함
        int answer = 1;
        for (int count : map.values()) {
            
            // count: 해당 종류 옷을 입는 경우의 수
            // +1: 해당 종류를 아예 입지 않는 경우
        
            // 각 종류 선택은 서로 독립적이므로 곱의 법칙 적용
            answer *= (count + 1);
        }
        
        // 모든 종류를 다 안 입는 경우
        return answer - 1;
    }
}
