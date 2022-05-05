package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTest {
	public static void main(String[] args) {
		List<int[]> ints=(getPageIndex(2,30));
		for (int i = 0; i < ints.size(); i++) {
			System.out.println(ints.get(i));
		}

	}
	public static List<int[]> getPageIndex(int currentPage, int pageSize) {
		List<int[]> indexList = new ArrayList<>();
		int[] list_count = {-1, -1, -1, -1, -1};
		//处理l1
		if (list_count[0] == -1) {

			list_count[0] = 0;
		}
		//当前页之前的总数
		int beforeTotal = (currentPage - 1) * pageSize;
//		if (list_count[0] >= beforeTotal) {
//			//可以满足整页数据量要求
//			int surplus = list_count[0] - beforeTotal;
//			int[] index = {beforeTotal, surplus > pageSize ? pageSize : surplus};
//			indexList.add(index);
//		} else {
//			int[] index = {0, 0};
//			indexList.add(index);
//		}


		indexList.add(getIndex(0, indexList, pageSize, list_count, beforeTotal));

		if (indexList.stream().map(item -> item[1]).reduce(0, (acc, n) -> acc + n) >= pageSize) {
			//indexList.stream().forEach(item -> Arrays.stream(item).forEach(System.out::println));
			return indexList;
		}

		//处理l2
		if (list_count[1] == -1) {
			list_count[1] = 0;
		}
		indexList.add(getIndex(1, indexList, pageSize, list_count, beforeTotal));

		if (indexList.stream().map(item -> item[1]).reduce(0, (acc, n) -> acc + n) >= pageSize) {
			//indexList.stream().forEach(item -> Arrays.stream(item).forEach(System.out::println));
			return indexList;
		}

		//处理l3
		if (list_count[2] == -1) {
			list_count[2] = 0;
		}
		indexList.add(getIndex(2, indexList, pageSize, list_count, beforeTotal));

		if (indexList.stream().map(item -> item[1]).reduce(0, (acc, n) -> acc + n) >= pageSize) {
			//indexList.stream().forEach(item -> Arrays.stream(item).forEach(System.out::println));
			return indexList;
		}

		//处理l4
		if (list_count[3] == -1) {
			list_count[3] = 1;
		}
		indexList.add(getIndex(3, indexList, pageSize, list_count, beforeTotal));

		if (indexList.stream().map(item -> item[1]).reduce(0, (acc, n) -> acc + n) >= pageSize) {
			//indexList.stream().forEach(item -> Arrays.stream(item).forEach(System.out::println));
			return indexList;
		}

		//处理l5
		if (list_count[4] == -1) {
			list_count[4] = 301;
		}
		indexList.add(getIndex(4, indexList, pageSize, list_count, beforeTotal));

		if (indexList.stream().map(item -> item[1]).reduce(0, (acc, n) -> acc + n) >= pageSize) {
			//indexList.stream().forEach(item -> Arrays.stream(item).forEach(System.out::println));
			return indexList;
		}

		indexList.stream().forEach(item -> Arrays.stream(item).forEach(System.out::println));
		return indexList;
	}

	private static int[] getIndex(int list_i, List<int[]> indexList, int pageSize, int[] list_count, int beforeTotal) {
		int[] index;
		//是否单独填满一页
		boolean whether_single = true;
		for (int i = 0; i < list_i; i++) {
			if (indexList.get(i)[1] > 0) {
				whether_single = false;
				break;
			}
		}
		if (!whether_single) {
			int need = pageSize;
			for (int i = 0; i < list_i; i++) {
				need -= indexList.get(i)[1];
			}
			index = new int[]{0, list_count[list_i] > need ? need : list_count[list_i]};
		} else {
			int start = beforeTotal;
			if (start > 0) {
				for (int i = 0; i < list_i; i++) {
					start -= list_count[i];
				}
				if (start >= list_count[list_i] || list_count[list_i] == 0) {
					index = new int[]{0, 0};
				} else {
					int endIndex = start + pageSize;
					index = new int[]{start, endIndex >= list_count[list_i] ? (list_count[list_i] - start) : pageSize};
				}
			} else {
				int need = pageSize;
				for (int i = 0; i < list_i; i++) {
					need -= indexList.get(i)[1];
				}
				index = new int[]{start, list_count[list_i] > need ? need : list_count[list_i]};
			}
		}
		return index;
	}
}
