/*jjs>*/ var BigInteger = Java.type('java.math.BigInteger')
/*jjs>*/ var b = new BigInteger('1234567890987654321')
/*jjs>*/ print(b)
// 1234567890987654321
/*jjs>*/ print(b.mod(BigInteger.TEN))
// 1
