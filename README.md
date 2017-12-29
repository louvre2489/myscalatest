# myscalatest
テスト駆動開発 Scala版

[書籍](https://estore.ohmsha.co.jp/titles/978427421788P)の内容をScalaで実装


- [ ] $5 + 10 CHF = $10(レートが2:1の場合)
- [x] ~~$5 * 2 = $10~~
- [x] ~~amountをprivateにする~~
- [x] ~~Dollarの副作用どうする？~~
- [ ] Moneyの丸めどうする？
- [x] ~~equals()~~ 最初からcase classで実装していたため、労せずクリアしてしまった・・・
- [ ] hashCode()
- [ ] nullとの等価性比較
- [ ] 他のオブジェクトとの等価性比較
- [x] ~~5 CHF * 2 = 10 CHF~~
- [x] ~~DollarとFrancの重複~~ Scalaにおいてはcase classでequalsを実装できるため、敢えて重複排除はしない
- [x] ~~equalsの一般化~~
- [x] ~~timesの一般化~~
- [x] ~~FrancとDollarを比較する~~
- [x] ~~通貨の概念~~
- [x] ~~testFrancMultiplicationを削除する？~~
- [x] ~~$5 + $5 = $10~~
- [ ] $5 + $5がMoneyを返す
- [x] ~~Bank.reduce(Money)~~