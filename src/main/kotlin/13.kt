fun main() {
    val s = "MDLXX"
    println(romanToInt(s))
}

fun romanToInt(s: String): Int {
    var output = 0
    var i = 0
    while (i <= s.lastIndex) {
        if (s[i] == 'I') {
            if (i != s.lastIndex) {
                if (s[i + 1] == 'V') {
                    output += 4
                    i += 2
                    continue
                }
                if (s[i + 1] == 'X') {
                    output += 9
                    i += 2
                    continue
                }
            }
        }
        if (s[i] == 'X') {
            if (i != s.lastIndex) {
                if (s[i + 1] == 'L') {
                    output += 40
                    i += 2
                    continue
                }
                if (s[i + 1] == 'C') {
                    output += 90
                    i += 2
                    continue
                }
            }
        }
        if (s[i] == 'C') {
            if (i != s.lastIndex) {
                if (s[i + 1] == 'D') {
                    output += 400
                    i += 2
                    continue
                }
                if (s[i + 1] == 'M') {
                    output += 900
                    i += 2
                    continue
                }
            }
        }
        output += getValue(s[i])
        i++
    }
    return output
}

private fun getValue(c: Char): Int {
    return when (c) {
        'I' -> {
            1
        }

        'V' -> {
            5
        }

        'X' -> {
            10
        }

        'L' -> {
            50
        }

        'C' -> {
            100
        }

        'D' -> {
            500
        }

        'M' -> {
            1000
        }

        else -> {
            0
        }
    }
}
