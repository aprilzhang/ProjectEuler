
public class Problem11 {
	private static int largestProductInGrid(int[][] grid)
	{
		int productHori = 0;
		int productVert = 0;
		int productDiag = 0;
		
		int max_so_far = 0;
		int countHori = 0;
		int countVert = 0;
		int countDiag = 0;
		for(int i = 0;i<grid[0].length;i++)
		{
			if(array[i]==0)
			{
				count = 0;
				product = 0;
				continue;
			}
			if(count<4)
			{
				product*=array[i];
				count++;
			}
			else 
			{
				product = max_at_current/array[i-4]*array[i];
			}
			
			if(count==4)
			{
				max_so_far = Math.max(max_so_far, product);
			}	
		}
	}
	
	private static int maxProductSubarray(int[] array)
	{

	}
}
