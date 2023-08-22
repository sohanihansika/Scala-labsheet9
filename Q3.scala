package lab9

object Q3 {
  class Account(initial: Double) {
    var balance: Double = initial

    def getBalance: Double = balance

    def deposit(amount: Double): Unit = {
      if (amount > 0) {
        balance += amount
        println(s"Deposited $amount. New balance: $balance")
      } else {
        println("Deposit amount must be positive.")
      }
    }

    def withdraw(amount: Double): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        println(s"Withdrew $amount. New balance: $balance")
      } else if (amount <= 0) {
        println("Withdraw amount must be positive.")
      } else {
        println("Insufficient funds for withdrawal.")
      }
    }

    def transfer(amount: Double, targetAccount: Account): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        targetAccount.balance += amount
        println(s"Transferred $amount to target account. New balance: $balance")
      } else if (amount <= 0) {
        println("Transfer amount must be positive.")
      } else {
        println("Insufficient funds for transfer.")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val acc1 = new Account(1000.0)
    val acc2 = new Account(500.0)

    println(s"Initial balance in account1: ${acc1.getBalance}")
    println(s"Initial balance in account2: ${acc2.getBalance}")

    acc1.deposit(1000.0)
    acc1.withdraw(800.0)
    acc1.transfer(200.0, acc2)

    println(s"Total balance in account1: ${acc1.getBalance}")
    println(s"Total balance in account2: ${acc2.getBalance}")
  }


}
