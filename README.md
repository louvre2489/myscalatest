# myscalatest
テスト駆動開発 Scala版

[書籍](https://estore.ohmsha.co.jp/titles/978427421788P)の内容をScalaで実装


- [x] $5 + 10 CHF = $10(レートが2:1の場合)
- [x] ~~$5 * 2 = $10~~
- [x] ~~amountをprivateにする~~
- [x] ~~Dollarの副作用どうする？~~
- [ ] ~~Moneyの丸めどうする？~~ 使用しなかった
- [x] ~~equals()~~  最初からcase classで実装していたため、あまり気にする必要がなかった
- [x] ~~hashCode()~~  最初からcase classで実装していたため、あまり気にする必要がなかった
- [x] ~~nullとの等価性比較~~  最初からcase classで実装していたため、あまり気にする必要がなかった
- [x] ~~他のオブジェクトとの等価性比較~~  最初からcase classで実装していたため、あまり気にする必要がなかった
- [x] ~~5 CHF * 2 = 10 CHF~~
- [x] ~~DollarとFrancの重複~~ Scalaにおいてはcase classでequalsを実装できるため、敢えて重複排除はしない
- [x] ~~equalsの一般化~~
- [x] ~~timesの一般化~~
- [x] ~~FrancとDollarを比較する~~
- [x] ~~通貨の概念~~
- [x] ~~testFrancMultiplicationを削除する？~~
- [x] ~~$5 + $5 = $10~~
- [x] ~~$5 + $5がMoneyを返す~~
- [x] ~~Bank.reduce(Money)~~
- [x] ~~Sum.Plus~~
- [x] ~~Expression.times~~