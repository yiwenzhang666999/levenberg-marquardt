package com.nus.example;

/**
 * Created by duy on 29/1/15.
 */

import com.nus.LmSumSquaresError;
import com.nus.LmSolver;

public class Main {
  public static void main(String[] args) {
    double[][] xy = {
      {2.2, 88.0}, {2.0, 60.6}, {1.9, 50.4}, {1.8, 42.0}, {1.28, 16.7758},
      {1.33, 18.286}, {1.12, 12.75}, {1.1, 12.33}, {0.8, 7.35}, {0.5, 4.22},
      {1.7, 35.0}, {1.5, 14.62}, {-14.8, -44.4}, {-14.0, -42.0}, {-12.0, -35.9},
      {-1.5, -4.4502}, {1.0, 10.4}, {0.0, 0.99}, {-1.0, -2.87}, {-2.0, -5.98},
      {-5.0, -15.0}, {-3.0, -8.9}, {-4.0, -11.9996}, {-10.0, -30.0},
      {-15.0, -43.0}, {-6.0, -17.99999}, {-4.5, -13.4998765}
    };

    int numData = xy.length;
    double x[] = new double[numData];
    double y[] = new double[numData];
    for (int i = 0; i < numData; ++i) {
      x[i] = xy[i][0];
      y[i] = xy[i][1];
    }

    ModelExpFunc model = new ModelExpFunc(x, y);
    LmSumSquaresError errorFunc = new LmSumSquaresError(model);

    LmSolver lmSolver = new LmSolver(0.1, 300, 0.00000001, errorFunc);

    double ab[] = {8, -10};
    lmSolver.solve(ab);

    System.out.println("Result: ");
    System.out.println(ab[0]);
    System.out.println(ab[1]);
  }
}