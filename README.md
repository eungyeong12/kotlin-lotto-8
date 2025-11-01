# 🍀 로또

## 📝 기능 목록
#### 1. 로또 구입 금액을 입력 받는다.
- 비어 있다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 정수로 변환되지 않는다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 양수가 아니라면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 1,000원으로 나누어 떨어지지 않는다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
#### 2. 로또 구입 금액으로부터 수량을 구한다.
#### 3. 로또 수량만큼 1에서 45 사이의 중복되지 않는 6개의 숫자를 뽑는다.
#### 4. 각 로또의 번호를 오름차순으로 정렬한다.
#### 5. 발행한 로또 수량 및 번호를 출력한다.
#### 6. 당첨 번호를 입력 받는다.
- 입력값을 쉼표를 기준으로 분리한다.
- 비어 있는 값이 있다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 정수로 변환되지 않는다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 6개가 아니라면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 1에서 45 사이의 범위가 아니라면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 6개의 숫자 중 중복되는 것이 있다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
#### 7. 보너스 번호를 입력 받는다.
- 비어 있다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 정수로 변환되지 않는다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 1에서 45 사이의 숫자가 아니라면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 당첨 번호와 중복되는 숫자라면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
#### 8. 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 몇 개의 숫자가 일치하는지 계산한다.
#### 9. 5개의 번호가 일치하는 경우, 나머지 하나가 보너스 번호와 일치하는지 판단하여 등수를 결정한다.
#### 10. 수익률을 계산한다.
#### 11. 당첨 내역을 출력한다.
#### 12. 수익률을 소수점 둘째 자리에서 반올림하여 출력한다.
