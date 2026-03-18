import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 1. 의상 종류별로 몇 개인지 저장할 해시맵 생성
        HashMap<String, Integer> map = new HashMap<>();
        
        // 2. 종류별 의상 개수 파악 (Key: 종류, Value: 개수)
        for (String[] cloth : clothes) {
            String category = cloth[1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        // 3. 각 종류별 (개수 + 1)을 모두 곱함 (1은 '입지 않음'의 경우)
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        
        // 4. 아무것도 입지 않은 경우 1을 빼고 반환
        return answer - 1;
    }
}