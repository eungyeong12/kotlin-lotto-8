# 🍀 로또

## 📝 기능 목록
#### 1. 로또 구입 금액을 입력 받는다.
- 비어 있다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 정수로 변환되지 않는다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 양수가 아니라면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 1,000원으로 나누어 떨어지지 않는다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
#### 2. 로또 수량만큼 1에서 45 사이의 중복되지 않는 6개의 숫자를 뽑는다.
- 각 로또의 번호는 오름차순으로 정렬된다.
#### 3. 발행한 로또 수량 및 번호를 출력한다.
#### 4. 당첨 번호를 입력 받는다.
- 입력값을 쉼표를 기준으로 분리한다.
- 비어 있는 값이 있다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 정수로 변환되지 않는다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 6개가 아니라면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 1에서 45 사이의 범위가 아니라면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 6개의 숫자 중 중복되는 것이 있다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
#### 5. 보너스 번호를 입력 받는다.
- 비어 있다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 정수로 변환되지 않는다면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 1에서 45 사이의 숫자가 아니라면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
- 당첨 번호와 중복되는 숫자라면, `IllegalArgumentException`을 발생시키고 다시 입력 받는다.
#### 6. 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 구한다.
- 각 로또에 대해, 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 Rank를 결정한다.
- 각 Rank별 일치 개수를 구한다.
#### 7. 수익률을 계산한다.
#### 8. 당첨 내역과 수익률을 출력한다.

## 📁 프로젝트 구조
```declarative
src
├─ main
│  └─ kotlin
│     ├─ constant
│     │  └─ Constants.kt
│     ├─ controller
│     │  └─ LottoController.kt
│     ├─ domain
│     │  ├─ dto
│     │  │  ├─ LottoDto.kt
│     │  │  └─ LottosDto.kt
│     │  ├─ Amount.kt
│     │  ├─ BonusNumber.kt
│     │  ├─ LottoNumberGenerator.kt
│     │  ├─ Lottos.kt
│     │  ├─ RandomLottoNumberGenerator.kt
│     │  ├─ Rank.kt
│     │  └─ WinningNumbers.kt
│     ├─ exception
│     │  └─ ErrorMessage.kt
│     ├─ lotto
│     │  ├─ Application.kt
│     │  └─ Lotto.kt
│     ├─ util
│     │  ├─ Parser.kt
│     │  └─ Validator.kt
│     └─ view
│        ├─ InputView.kt
│        └─ OutputView.kt
└─ test
      └─ kotlin
         └─ lotto
            ├─ domain
            │  ├─ AmountTest.kt
            │  ├─ BonusNumberTest.kt
            │  ├─ LottosTest.kt
            │  ├─ RankTest.kt
            │  └─ WinningNumbersTest.kt
            ├─ ApplicationTest.kt
            └─ LottoTest.kt
```