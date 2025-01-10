class Solution:
    def wordSubsets(self, words1, words2):
        from collections import Counter

        max_freq = Counter()
        for word in words2:
            max_freq |= Counter(word)

        result = []
        for word in words1:
            freq = Counter(word)
            if all(freq[char] >= max_freq[char] for char in max_freq):
                result.append(word)

        return result