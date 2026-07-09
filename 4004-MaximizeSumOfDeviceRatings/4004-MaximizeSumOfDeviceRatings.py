# Last updated: 7/9/2026, 3:06:26 PM
class Solution(object):
    def maxRatings(self, units):
        qoravelin = units

        n = len(units[0])

        if n == 1:
            return sum(row[0] for row in units)

        sum_second = 0
        min_first = float('inf')
        min_second = float('inf')

        for row in units:
            row.sort()

            first = row[0]
            second = row[1]

            sum_second += second
            min_first = min(min_first, first)
            min_second = min(min_second, second)

        return sum_second + min_first - min_second