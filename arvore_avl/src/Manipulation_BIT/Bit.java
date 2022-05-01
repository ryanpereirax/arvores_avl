package Manipulation_BIT ;

public class Bit {

	public static void main(String[] args) {

		System.out.println(powerOfTwo(16));

	}

	public static int extractBit(int n, int i) {

		int mask = 1;

		mask = 1 << (i - 1);

		n = n & mask;

		return (n == 0 ? 0 : 1);

	}

	public static int setBit(int n, int i) {

		int mask = 1;

		mask = 1 << (i - 1);

		n = n | mask;

		return n;

	}

	public static int resetBit(int n, int i) {

		int mask = 1;

		mask = ~(1 << (i - 1));

		n = n & mask;

		return n;

	}

	public static int rightmostSetBit(int n) {

		int pos = 1;

		int mask = 1;

		while ((n & mask) == 0) {

			pos++;
			mask = mask << 1;
		}

		return pos;
	}

	public static int addOne(int n) {

		int mask = 1;

		while ((n & mask) != 0) {

			n = n ^ mask;
			mask = (mask << 1);
		}

		n = n ^ mask;

		return n;

	}

	public static int magicNo(int i) {

		int ans = 0;
		int pow = 1;

		while (i != 0) {

			pow = pow * 5;

			if ((i & 1) != 0) {
				ans = ans + pow;
			}

			i = (i >> 1);

		}

		return ans;

	}

	public static int pascalSum(int n) {

		int res = (1 << n);

		return res - 1;

	}

	public static boolean powerOfTwo(int n) {

		if (n != 0) {

			if ((n & (n - 1)) == 0) {
				return true;
			}
		}
		
		return false;

	}

}
