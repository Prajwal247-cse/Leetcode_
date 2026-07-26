from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        # Edge case
        if len(p) > len(s):
            return []

        k = len(p)

        # Frequency arrays
        pattern = [0] * 26
        window = [0] * 26

        # Build pattern frequency
        for ch in p:
            pattern[ord(ch) - ord('a')] += 1

        ans = []
        left = 0

        # Sliding window
        for right in range(len(s)):

            # Expand window
            window[ord(s[right]) - ord('a')] += 1

            # Shrink if window size > k
            if right - left + 1 > k:
                window[ord(s[left]) - ord('a')] -= 1
                left += 1

            # Process when window size == k
            if right - left + 1 == k:
                if window == pattern:
                    ans.append(left)

        return ans