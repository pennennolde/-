package codingChallenge2017Spring;

public class Level3_5 {


	public static void main(String[] args) {

		/*
		 *  Goodfind Engineer
		 *  Coding Challenge 2017 Spring
		 *
		 *  問題：Level3
		 *  (3+√7)^(20^17) の整数部分の下10桁を求めるプログラムを作成せよ！
		 *
		 */

		/*
		 *         ( 3 + √7 )^2
		 *     = ( 5 + 0.645... )^2
		 *            x          y
		 *    = x^2 + 2*x*y + y^2
		 *             >x           >x          <0
		 *
		 */


		// (a + b√7)
		long a = 3;
		long b = 1;
		double root7 = Math.sqrt(7);
		System.out.println("    " + root7);

		// 整数部分と小数部分に分ける
		long integer = a;
		double decimal = b*root7;
		integer += (long)decimal;
		decimal -= (long)decimal;

		System.out.println(integer+" + "+decimal);


		long next_int = 0;
		double next_dec = 0.0;

		long int4 = 0;
		double dec4 = 0.0;

		for(int i=0; i<4; i++) {

			// (     5     +  0.645...)^2
			// integer    decimal
			next_int = integer*integer;
			next_dec = decimal*decimal;
			next_int += (long)(2*integer*decimal);
			next_dec += 2*integer*decimal - (long)(2*integer*decimal);
			System.out.println(next_dec);
			next_int += (long)next_dec;
			next_dec -= (long)next_dec;

			next_dec = (long)(next_dec*100000000000000L);
			next_dec = (double)(next_dec/100000000000000L);

			if( next_int>=100000000000000000L ) {
				next_int %= 100000000000000000L;
			}

			System.out.println(next_int +" + "+next_dec );

			integer = next_int;
			decimal = next_dec;

			if( i==1 ) {
				int4 = integer;
				dec4 = decimal;
			}


		}




		next_int = integer*int4;
		next_dec = decimal*dec4;
		next_int += (long)(integer*dec4);
		next_int += (long)(int4*decimal);
		next_dec += integer*dec4 - (long)(integer*dec4);
		next_dec += int4*decimal - (long)(int4*decimal);
		System.out.println(next_dec);
		next_int += (long)next_dec;
		next_dec -= (long)next_dec;

		next_dec = (long)(next_dec*100000000000000L);
		next_dec = (double)(next_dec/100000000000000L);

		if( next_int>=100000000000000000L ) {
			next_int %= 100000000000000000L;
		}

		System.out.println(next_int +" + "+next_dec );

		integer = next_int;
		decimal = next_dec;



	}




}
