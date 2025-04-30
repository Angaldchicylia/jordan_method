package com.examples.Angald;

public class JordanElimination {
    public static void solve(double[][] A, double[] b) {
        int n = A.length;

        for (int k = 0; k < n; k++) {
            int maxRow = k;
            double maxVal = Math.abs(A[k][k]);
            // Ищем строку с максимальным элементом в текущем столбце (ниже и включая диагональ)
            for (int i = k; i < n; i++) {
                if (Math.abs(A[i][k]) > maxVal) {
                    maxVal = Math.abs(A[i][k]);
                    maxRow = i;
                }
            }

            // Проверка на вырожденность системы
            if (maxVal == 0) {
                throw new ArithmeticException("Матрица вырождена, система не имеет единственного решения");
            }

            // Шаг 2: Перестановка строк, если необходимо
            if (maxRow != k) {
                // Меняем строки в матрице A
                double[] tmpRow = A[k];
                A[k] = A[maxRow];
                A[maxRow] = tmpRow;

                // Меняем соответствующие элементы в векторе b
                double tempB = b[k];
                b[k] = b[maxRow];
                b[maxRow] = tempB;
            }

            // Шаг 3: Нормализация ведущей строки
            double pivot = A[k][k];
            for (int j = k; j < n; j++) {
                A[k][j] /= pivot;
            }
            b[k] /= pivot;

            // Шаг 4: Исключение переменной из всех строк, кроме текущей
            for (int i = 0; i < n; i++) {
                if (i != k) {
                    double factor = A[i][k];
                    for (int j = k; j < n; j++) {
                        A[i][j] -= factor * A[k][j];
                    }
                    b[i] -= factor * b[k];
                }
            }
        }

    }
}