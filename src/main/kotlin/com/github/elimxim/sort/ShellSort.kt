package com.github.elimxim.sort

import com.github.elimxim.*
import com.github.elimxim.Probe.Counter.*

@SortAlgorithm(
        timeComplexity = TimeComplexity(
                worst = Complexity.HALF_QUADRATIC,
                average = Complexity.THIRD_QUADRATIC,
                best = Complexity.LINEARITHMIC
        ),
        spaceComplexity = Complexity.CONST,
        pseudoCode = """
        gap = n / 2
        while gap > 0 do
            for i in [gap..n) do
                v = array[i]
                j = i
                while j >= gap do
                    if array[j-gap] > v then
                        array[j] = array[j-gap]
                    else
                        break
                    end
                    j -= gap
                end
                
                if j != i then
                    array[j] = v
                end
            end
            gap /= 2
        end
        """
)
class ShellSort(
        private val probe: Probe,
        private val script: SortScript
) : Sort {
    override fun sort(array: IntArrayWrapper) {
        var gap = array.size() / 2
        while (gap > 0) {
            probe.increment(ITERATIONS)
            for (i in gap..<array.size()) {
                probe.increment(ITERATIONS)
                val value = array[i]
                var j = i
                script.line(Focus(i), Extra(value))
                val bulkMove = script.bulkMove()
                while (j >= gap && array[j - gap] > value) {
                    probe.increment(ITERATIONS, COMPARISONS)
                    array[j] = array[j - gap]
                    bulkMove.add(j - gap, j)
                    j -= gap
                }

                if (bulkMove.isNotEmpty()) {
                    array[j] = 0
                    script.line(bulkMove, Extra(value))
                }

                if (j != i) {
                    array[j] = value
                    script.line(Select(j), Extra(value))
                }
            }

            gap /= 2
        }
    }
}