package longmath;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:04:46 PM 

public class BigInteger {

	private static final int N = 1024;
	private static final int BASE = 65536;

	private int[] digits = new int[N];
	private int sign = 1;

	private BigInteger() {
		/**/ }

	private BigInteger(final BigInteger other) {
		System.arraycopy(other.digits, 0, digits, 0, N);
		sign = other.sign;
	}

	public static BigInteger valueOf(long value) {
		return null;
	}

	public static BigInteger valueOf(BigInteger value) {
		return new BigInteger(value);
	}

	// interface

	public BigInteger add(BigInteger value) {
		return null;
	}

	public BigInteger add(long value) {
		return null;
	}

	public BigInteger add(BigInteger value, long MOD) {
		return null;
	}

	public BigInteger add(long value, long MOD) {
		return null;
	}

	public BigInteger substract(BigInteger value) {
		return null;
	}

	public BigInteger substract(long value) {
		return null;
	}

	public BigInteger substract(BigInteger value, long MOD) {
		return null;
	}

	public BigInteger substract(long value, long MOD) {
		return null;
	}

	public BigInteger mul(BigInteger value) {
		return null;
	}

	public BigInteger mul(long value) {
		return null;
	}

	public BigInteger mul(BigInteger value, long MOD) {
		return null;
	}

	public BigInteger mul(long value, long MOD) {
		return null;
	}

	public BigInteger div(BigInteger value) {
		return null;
	}

	public BigInteger div(long value) {
		return null;
	}

	public BigInteger mod(BigInteger value) {
		return null;
	}

	public BigInteger pow(long exp) {
		return null;
	}

	public BigInteger pow(long exp, long MOD) {
		return null;
	}

	public BigInteger abs() {
		if (sign == 1)
			return valueOf(this);
		else {
			BigInteger num = valueOf(this);
			num.sign = -1 * num.sign;
			return num;
		}
	}

}
