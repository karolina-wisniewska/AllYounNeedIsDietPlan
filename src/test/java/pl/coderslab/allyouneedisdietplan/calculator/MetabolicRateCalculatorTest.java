package pl.coderslab.allyouneedisdietplan.calculator;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MetabolicRateCalculatorTest {

  @Test
  void calculateForMale() {
    //given
    double currentWeight = 50;
    double dreamWeight = 49;
    int height = 160;
    int userAge = 30;
    double activityLevel = 1.2;
    Long expected = 1121L;

    //when
    MetabolicRateCalculator metabolicRateCalculator = new MetabolicRateCalculator("male");

    //then
    assertEquals(expected, metabolicRateCalculator.calculate(currentWeight, dreamWeight, height, userAge, activityLevel));
  }

  @Test
  void calculateForFemale() {
    //given
    double currentWeight = 50;
    double dreamWeight = 49;
    int height = 160;
    int userAge = 30;
    double activityLevel = 1.2;
    Long expected = 975L;

    //when
    MetabolicRateCalculator metabolicRateCalculator = new MetabolicRateCalculator("female");

    //then
    assertEquals(expected, metabolicRateCalculator.calculate(currentWeight, dreamWeight, height, userAge, activityLevel));
  }

  @Test
  void calculateSuccessDateForDifferenceBelow15() {
    //given
    double weightDifference = 5;
    LocalDateTime expected = LocalDateTime.now().plusDays(70);

    //when
    MetabolicRateCalculator metabolicRateCalculator = new MetabolicRateCalculator("male");
    LocalDateTime result = metabolicRateCalculator.calculateSuccessDate(weightDifference);

    //then
    assertEquals(expected.getYear(), result.getYear());
    assertEquals(expected.getMonthValue(), result.getMonthValue());
    assertEquals(expected.getDayOfMonth(), result.getDayOfMonth());
  }

  @Test
  void calculateSuccessDateForDifferenceAbove15() {
    //given
    double weightDifference = 17;
    LocalDateTime expected = LocalDateTime.now().plusDays(119);

    //when
    MetabolicRateCalculator metabolicRateCalculator = new MetabolicRateCalculator("male");
    LocalDateTime result = metabolicRateCalculator.calculateSuccessDate(weightDifference);

    //then
    assertEquals(expected.getYear(), result.getYear());
    assertEquals(expected.getMonthValue(), result.getMonthValue());
    assertEquals(expected.getDayOfMonth(), result.getDayOfMonth());
  }
}