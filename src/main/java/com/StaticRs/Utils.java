package com.StaticRs;

import java.util.Map;

import com.StaticRs.pojo.CartItem;

public class Utils {
	public static int countCart(Map<Integer, CartItem> carts) {
		int cnt = 0;
		if (carts != null) {
			for (CartItem c : carts.values()) {
				cnt += c.getCount();
			}

		}
		return cnt;

	}
}
