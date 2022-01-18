	/**
	 * pulls the bubbles to the ground(down) and then across (left)
	 */	
	private void gravityAndShove() {
		for (int x = 0; x < BubbleMap.length; x++) {
			for (int y = 0; y < BubbleMap[x].length; y++) {
				if (BubbleMap[x][y] != null) {//current null check
					if (x <= COLS - 2) {//border check
						if (BubbleMap[x + 1][y] == null) {//up null check,
							BubbleMap[x][y].setBubbleXY(x + 1, y);
							BubbleMap[x + 1][y] = BubbleMap[x][y];
							BubbleMap[x][y] = null;
							gravityAndShove();
						}
					}
				}
				if (BubbleMap[x][y] != null) {
					if (y > 0) {//border check
						if (BubbleMap[x][y - 1] == null) {//right null check
							BubbleMap[x][y].setBubbleXY(x, y - 1);
							BubbleMap[x][y - 1] = BubbleMap[x][y];
							BubbleMap[x][y] = null;
							gravityAndShove();
						}
					}
				}
			}
		}
	}

	/**
	 * This is the public call for selecting a group of bubble to remove
	 *
	 * @param x the x location of the bubble on the BubbleMap
	 * @param y the y location of the bubble on the BubbleMap
	 */
	public void clickBubble(int x, int y) {
		ArrayList<Bubble> clearBubbles = new ArrayList<>();
		clearBubbles.add(BubbleMap[x][y]);
		search(x, y, clearBubbles, PREDIRECTION.TOP, PREDIRECTION.RIGHT, PREDIRECTION.BOTTOM, PREDIRECTION.LEFT);

		Iterator<Bubble> it = clearBubbles.iterator();//the test printing the bubbles
		if (clearBubbles.get(0) == null) {//if the bubble doesn't exist
			System.out.println("No Match");
		} else if (clearBubbles.size() < 2) {//if the bubble is less then 2
			System.out.println("Not Enough Bubbles");
		} else {
			System.out.print("Values: ");
			while (it.hasNext()) {
				System.out.print(it.next().getColour() + ", ");
			}
		}
		System.out.println("\nSize: " + clearBubbles.size() + "\n");
	}

	/**
	 * This method finds all of the bubbles in the area of the original bubble
	 * that is the same colour
	 *
	 * @param x the x location of the bubble on the BubbleMap that need to be
	 * searched around
	 * @param x the x location of the bubble on the BubbleMap that need to be
	 * searched around
	 * @param clearBubbles the array that storages the list of bubbles to be
	 * cleared
	 * @param direction the previous direction that was searched
	 */
	private void findBubble(int x, int y, ArrayList clearBubbles, PREDIRECTION direction) {//move to click bubble? as not longer recusive
		if (!(x < 0 || x >= COLS || y < 0 || y >= ROWS)) {//edge cases
			if (BubbleMap[x][y] != null) {//null check
				if (!(clearBubbles.contains(BubbleMap[x][y])) && clearBubbles.get(0) != null) {//clearbubbles array check and clearbubbles null check
					if (BubbleMap[x][y].getColour() == PreDirection(x, y, direction).getColour()) {//colour check
						clearBubbles.add(BubbleMap[x][y]);
						switch (direction) {
							case TOP:
								search(x, y, clearBubbles, PREDIRECTION.RIGHT, PREDIRECTION.BOTTOM, PREDIRECTION.LEFT);
								break;
							case RIGHT:
								search(x, y, clearBubbles, PREDIRECTION.TOP, PREDIRECTION.BOTTOM, PREDIRECTION.LEFT);
								break;
							case BOTTOM:
								search(x, y, clearBubbles, PREDIRECTION.TOP, PREDIRECTION.RIGHT, PREDIRECTION.LEFT);
								break;
							case LEFT:
								search(x, y, clearBubbles, PREDIRECTION.TOP, PREDIRECTION.RIGHT, PREDIRECTION.BOTTOM);
								break;
						}
					}//colour check
				}//clearbubbles array check and clearbubbles null check
			}//null check
		}//edge check
	}

	/**
	 * This method removes individual Bubbles after a chain of bubbles have been
	 * identified to clear. Through the use of the gravity and push left methods
	 * this also insures that all the bubbles stay as close to the bottom left
	 * corner as possible, to make playing the game easier.
	 *
	 * @param x position of the Bubble that needs to be removed
	 * @param y position of the Bubble that needs to be removed
	 */
	private void removeBubble(int x, int y) {//make me private, can we change the side to happen after removal
		BubbleMap[x][y] = null;
		gravity(x, y);
	}

	/**
	 * Pushes the bubbles down from the given x and y position.
	 *
	 * @param the x position that needs gravity applied
	 * @param the y position that needs gravity applied
	 */
	private void gravity(int x, int y) {
		if (x != 0) {
			if (BubbleMap[x - 1][y] != null) {
				BubbleMap[x][y] = BubbleMap[x - 1][y];
				BubbleMap[x][y].setBubbleXY(x, y);
				removeBubble(x - 1, y);
			} else {
				pushLeft(x, y);
			}
		} else {
			pushLeft(x, y);
		}

	}

	/**
	 * Pushes the bubbles left from the x and y position given.
	 *
	 * @param the x position that needs to be pushed left
	 * @param the y position that needs to be pushed left
	 */
	private void pushLeft(int x, int y) {
		if (y != ROWS - 1) {
			if (BubbleMap[x][y + 1] != null) {
				BubbleMap[x][y] = BubbleMap[x][y + 1];
				BubbleMap[x][y].setBubbleXY(x, y);
				removeBubble(x, y + 1);
			}
		}
	}

	/**
	 * this method is made to return the bubble previously searched around to
	 * check if the current bubble is the same colour
	 *
	 * @param x the x location of the current bubble on the BubbleMap
	 * @param y the y location of the current bubble on the BubbleMap
	 * @param direction the direction the current bubble was found from
	 * @return the bubble at the previous location
	 */
	private Bubble PreDirection(int x, int y, PREDIRECTION direction) {
		switch (direction) {
			case TOP:
				return BubbleMap[x + 1][y];
			case RIGHT:
				return BubbleMap[x][y - 1];
			case BOTTOM:
				return BubbleMap[x - 1][y];
			case LEFT:
				return BubbleMap[x][y + 1];
		}
		return null;
	}

	/**
	 * this method runs through a list of directions to search based off all 4
	 * direction minus the previous direction as that has all ready been
	 * searched
	 *
	 * @param x the x location on the BubbleMap
	 * @param y the y location of the BubbleMap
	 * @param clearBubbles the array of Bubble that need to be cleared
	 * @param args the directions that need to be searched
	 */
	private void search(int x, int y, ArrayList clearBubbles, PREDIRECTION... args) {//remove predirection?? and use clearBubbles.contains and clearBubbles.get(0).getColour?
		for (PREDIRECTION arg : args) {
			switch (arg) {
				case TOP:
					findBubble(x - 1, y, clearBubbles, PREDIRECTION.TOP);
					break;
				case RIGHT:
					findBubble(x, y + 1, clearBubbles, PREDIRECTION.RIGHT);
					break;
				case BOTTOM:
					findBubble(x + 1, y, clearBubbles, PREDIRECTION.BOTTOM);
					break;
				case LEFT:
					findBubble(x, y - 1, clearBubbles, PREDIRECTION.LEFT);
					break;
			}
		}
	}

	public enum PREDIRECTION {
	TOP,RIGHT,BOTTOM,LEFT;	
	}

	//could be uses to make code ridiculously solid for dynamic print of any size BubbleMap
	int spaces = String.valueOf(ROWS).length() - 1;
	spaces = String.valueOf(COLS).length() + 1;