package app.calculator.distanceCalculator.models;

public class DistanceValue {

  private Number distance;
  private DistanceUnit is;

  public Number getDistance() {
    return distance;
  }

  public DistanceUnit getIs() {
    return is;
  }

  public DistanceValue(Number distance, DistanceUnit is) {
    this.distance = distance;
    this.is = is;
  }

  public DistanceValue convert(DistanceUnit to) {
    //convert to meters then to the desired unit using switch
    Number convertedDistance = 0;
    switch (this.is) {
      case METRE:
        convertedDistance = this.distance;
        break;
      case KILOMETRE:
        convertedDistance = this.distance.doubleValue() * 1000;
        break;
      case CENTIMETRE:
        convertedDistance = this.distance.doubleValue() / 100;
        break;
      case MILLIMETRE:
        convertedDistance = this.distance.doubleValue() / 1000;
        break;
      default:
        break;
    }

    switch (to) {
      case METRE:
        break;
      case KILOMETRE:
        convertedDistance = convertedDistance.doubleValue() / 1000;
        break;
      case CENTIMETRE:
        convertedDistance = convertedDistance.doubleValue() * 100;
        break;
      case MILLIMETRE:
        convertedDistance = convertedDistance.doubleValue() * 1000;
        break;
      default:
        break;
    }
    return new DistanceValue(convertedDistance, to);
  }

  public static String getSmallRepr(DistanceUnit unit) {
    switch (unit) {
      case METRE:
        return "m";
      case KILOMETRE:
        return "km";
      case CENTIMETRE:
        return "cm";
      case MILLIMETRE:
        return "mm";
      default:
        return null;
    }
  }

  @Override
  public String toString() {
    return this.distance + "" + getSmallRepr(this.is);
  }
}
