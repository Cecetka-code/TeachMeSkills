package by.tms.entity;

public class Calculator {
    private double first;
    private double second;
    private String sign;
    private double result;

    public Calculator() {
    }

    public Calculator(double first, double second, String sign) {
        this.first = first;
        this.second = second;
        this.sign = sign;
    }

    public double calculation() {
        switch (this.sign) {
            case "+": {
                result = sum();
                break;
            }
            case "-": {
                result = sub();
                break;
            }
            case "/": {
                result = div();
                break;
            }
            case "*": {
                result = mul();
                break;
            }
            default:
                result = 0;
        }
        return result;
    }

    private double sum() {
        return (this.first + this.second);
    }

    private double sub() {
        return (this.first - this.second);
    }

    private double div() {
        return (this.first / this.second);
    }

    private double mul() {
        return (this.first * this.second);
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "first=" + first +
                ", second=" + second +
                ", sign='" + sign + '\'' +
                ", result=" + result +
                '}';
    }
}
