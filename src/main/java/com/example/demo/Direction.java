package com.example.demo;

public enum Direction {
	NORTH(0, -1), EAST(1, 0), SOUTH(0, 1), WEST(-1, 0);

	public int dx, dy;

	private Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	// クラスメソッド values は，この列挙で定義している列挙定数を，
	// 定義順に格納した配列を返す。
	// メソッド ordinal は，この列挙定数の定義順（先頭は Ø ）を返す。
	public Direction left() {
		return values()[(ordinal() + 3) % 4];
	}

	public Direction right() {
		return values()[(ordinal() + 1) % 4];
	}
}