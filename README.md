# java-strings-demo

Demo project for the `Confusing Java Strings` talk.

# Example Output

```
AdoptOpenJDK 15+36 (OpenJDK 64-Bit Server VM)

--- Length ---
Java -> 4
我喜欢茶 -> 4
𝕒𝕓𝕔 -> 6
👩❤☕ -> 4
👩‍💻❤️🍵 -> 9

--- Code Point Count ---
Java -> 4
我喜欢茶 -> 4
𝕒𝕓𝕔 -> 3
👩❤☕ -> 3
👩‍💻❤️🍵 -> 6

--- Code Points ---
Java -> U+4A U+61 U+76 U+61
我喜欢茶 -> U+6211 U+559C U+6B22 U+8336
𝕒𝕓𝕔 -> U+1D552 U+1D553 U+1D554
👩❤☕ -> U+1F469 U+2764 U+2615
👩‍💻❤️🍵 -> U+1F469 U+200D U+1F4BB U+2764 U+FE0F U+1F375

--- Code Units ---
Java -> \u4A \u61 \u76 \u61
我喜欢茶 -> \u6211 \u559C \u6B22 \u8336
𝕒𝕓𝕔 -> \uD835 \uDD52 \uD835 \uDD53 \uD835 \uDD54
👩❤☕ -> \uD83D \uDC69 \u2764 \u2615
👩‍💻❤️🍵 -> \uD83D \uDC69 \u200D \uD83D \uDCBB \u2764 \uFE0F \uD83C \uDF75

--- Buggy Reverse ---
Java -> avaJ
我喜欢茶 -> 茶欢喜我
𝕒𝕓𝕔 -> ?𝕓𝕒?
👩❤☕ -> ☕❤??
👩‍💻❤️🍵 -> ??️❤??‍??

--- Reverse ---
Java -> avaJ
我喜欢茶 -> 茶欢喜我
𝕒𝕓𝕔 -> 𝕔𝕓𝕒
👩❤☕ -> ☕❤👩
👩‍💻❤️🍵 -> 🍵️❤💻‍👩
```
