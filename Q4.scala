package lab9

object Q4 {
  class Account(initial: Double) {
    var balance: Double = initial

    def getBalance: Double = balance

    def applyInterest(): Unit = {
      if (balance > 0) {
        balance += balance * 0.05
      } else if (balance < 0) {
        balance += balance * 0.1
      }
    }
  }

  class Bank(accounts: List[Account]) {
    def getAccounts: List[Account] = accounts

    def negativeBalances: List[Account] = accounts.filter(_.getBalance < 0)

    def totalBalance: Double = accounts.map(_.getBalance).sum

    def applyInterestToAll(): Unit = {
      accounts.foreach(_.applyInterest())
    }
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000.0)
    val account2 = new Account(-500.0)
    val account3 = new Account(200.0)
    val account4 = new Account(-100.0)

    val bank = new Bank(List(account1, account2, account3, account4))

    println("List of accounts with negative balances:")
    bank.negativeBalances.foreach(account => println(account.getBalance))

    println(s"\nThe sum of all account balances: ${bank.totalBalance}")

    bank.applyInterestToAll()

    println("\nFinal balances of all accounts after applying interest:")
    bank.getAccounts.foreach(account => println(account.getBalance))
  }


}
