public class LevenshteinDistance extends WordChecker {
	
	private int DISTANCE;
	private String A;
	private String B;

	public LevenshteinDistance(String a, String b) {
		this.A = a;
		this.B = b;
	}
	
	private void getLevenshteinDistance() {
		if (A == null || B == null) {
			throw new IllegalArgumentException("Strings must not be null");
		}
		
		int n = A.length();
		int m = B.length();
		
		if (n > m) {
			String tmp = A;
			A = B;
			B = tmp;
			n = m;
			m = B.length();
		}
		
		int[] p = new int[n + 1];
		int[] d = new int[n + 1];
		int[] _d;
		
		int i, j, cost;
		
		char t_j;
		
		for (i = 0; i <= n; i++)
				p[i] = i;
		
		for (j = 1; j <= m; j++) {
			t_j = B.charAt(j - 1);
			d[0] = j;
			
			for (i = 1; i <= n; i++) {
				cost = A.charAt(i - 1) == t_j ? 0 : 1;
				d[i] = Math.min(Math.min(d[i - 1] + 1, p[i] + 1),  p[i - 1] + cost);
			}
			
			_d = p;
			p = d;
			d = _d;
		}
		this.DISTANCE = p[n];
	}
	
	public int returnCost() {
		
		getLevenshteinDistance();
		return DISTANCE;
	}
}