def countOfSubstrings(word: str, k: int) -> int:
    return atleast(k, word) - atleast(k + 1, word)

def atleast(k, word):
    count = consonants = left = 0
    freq = {}
    n = len(word)
    vowels = {'a', 'e', 'i', 'o', 'u'}

    for right in range(n):
        ch = word[right]
        if ch not in vowels:
            consonants += 1

        freq[ch] = freq.get(ch, 0) + 1

        while consonants >= k and hasAllVowels(freq):
            count += (n - right)
            leftChar = word[left]
            if leftChar not in vowels:
                consonants -= 1
            freq[leftChar] -= 1
            if freq[leftChar] == 0:
                del freq[leftChar]
            left += 1

    return count

def hasAllVowels(freq):
    return all(freq.get(v, 0) > 0 for v in "aeiou")