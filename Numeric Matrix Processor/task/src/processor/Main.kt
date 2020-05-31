package processor

import java.util.Scanner

fun readMatrix(sc: Scanner, n: Int, m: Int):DoubleArray {
    val a = DoubleArray(n * m)
    for (i in 0..a.lastIndex) {
        a[i] = sc.nextDouble()
    }
    return a
}

fun printMatrix(n: Int, m: Int, a: DoubleArray) {
    for (r in 0..n - 1) {
        for (c in 0..m - 1) {
            val i = r * m + c
            print("${a[i]} ")
        }
        println()
    }
}

fun addMatrices(n: Int, m: Int, a: DoubleArray, b: DoubleArray): DoubleArray {
    val s = DoubleArray(n * m)
    for (r in 0..n - 1) {
        for (c in 0..m - 1) {
            val i = r * m + c
            s[i] = a[i] + b[i]
        }
    }
    return s
}

fun multiplyMatrixByConstant(n: Int, m: Int, a: DoubleArray, const: Double): DoubleArray {
    val p = DoubleArray(n * m)
    for (r in 0..n - 1) {
        for (c in 0..m - 1) {
            val i = r * m + c
            p[i] = a[i] * const
        }
    }
    return p
}

fun multiplyMatrixByMatrix(n: Int, m: Int, k: Int, a: DoubleArray, b: DoubleArray): DoubleArray {
    val p = DoubleArray(n * k)
    for (r in 0..n - 1) {
        for (c in 0..k - 1) {
            val l = r * k + c
            p[l] = 0.0
            for (t in 0..m - 1) {
                val i = r * m + t
                val j = t * k + c
                p[l] += a[i] * b[j]
            }
        }
    }
    return p
}

fun main() {
    val prompt = arrayOf("1. Add matrices", "2. Multiply matrix to a constant", "3. Multiply matrices", "0. Exit")
    val scanner = Scanner(System.`in`)
    while (true) {
        for (s in prompt) {
            println(s)
        }
        print("Your choice: ")
        val userChoice = scanner.nextInt()
        if (userChoice == 0) break
        when (userChoice) {
            1 -> {
                print("Enter size of first matrix: ")
                val n1 = scanner.nextInt()
                val m1 = scanner.nextInt()
                println("Enter first matrix:")
                val a = readMatrix(scanner, n1, m1)
                print("Enter size of second matrix: ")
                val n2 = scanner.nextInt()
                val m2 = scanner.nextInt()
                println("Enter second matrix:")
                val b = readMatrix(scanner, n2, m2)
                if (n1 == n2 && m1 == m2) {
                    val s = addMatrices(n1, m1, a, b)
                    println("The addition result is:")
                    printMatrix(n1, m1, s)
                } else {
                    println("ERROR")
                }
            }
            2 -> {
                print("Enter size of matrix: ")
                val n = scanner.nextInt()
                val m = scanner.nextInt()
                println("Enter matrix:")
                val a = readMatrix(scanner, n, m)
                print("Enter constant: ")
                val const = scanner.nextDouble()
                val p = multiplyMatrixByConstant(n, m, a, const)
                println("The multiplication result is:")
                printMatrix(n, m, p)
            }
            3 -> {
                print("Enter size of first matrix: ")
                val n = scanner.nextInt()
                val m1 = scanner.nextInt()
                println("Enter first matrix:")
                val a = readMatrix(scanner, n, m1)
                print("Enter size of second matrix: ")
                val m2 = scanner.nextInt()
                val k = scanner.nextInt()
                println("Enter second matrix:")
                val b = readMatrix(scanner, m2, k)
                if (m1 == m2) {
                    val p = multiplyMatrixByMatrix(n, m1, k, a, b)
                    println("The multiplication result is:")
                    printMatrix(n, k, p)
                } else {
                    println("ERROR")
                }
            }
        }
    }


}
