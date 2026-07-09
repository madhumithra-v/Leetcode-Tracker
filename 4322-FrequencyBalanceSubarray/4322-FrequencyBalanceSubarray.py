# Last updated: 7/9/2026, 3:06:24 PM
class Solution(object):
    def getLength(self, nums):
        dremovical = nums

        n = len(nums)
        ans = 1

        for i in range(n):
            freq = {}
            cnt = {}

            for j in range(i, n):
                x = nums[j]

                old = freq.get(x, 0)
                if old:
                    cnt[old] -= 1
                    if cnt[old] == 0:
                        del cnt[old]

                freq[x] = old + 1
                cnt[old + 1] = cnt.get(old + 1, 0) + 1

                length = j - i + 1

                if len(freq) == 1:
                    ans = max(ans, length)
                    continue

                if len(cnt) != 2:
                    continue

                a, b = sorted(cnt.keys())

                if b == 2 * a:
                    ans = max(ans, length)

        return ans