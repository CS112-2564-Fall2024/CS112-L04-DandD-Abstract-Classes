public abstract class GameCharacter {
    private String name = null;
    private String className = null;
    private String alignment = null;
    private int gold = 0;
    private int xp = 0;
    private int hp = 0;
    private int ac = 0;
    private Weapon weapon1 = null;
    private Weapon weapon2 = null;
    
    /**
     * Create a GameCharacter from a subclass */
    protected GameCharacter() {
    }

    /**
     * 
     * @param gold Character's Gold Currency
     */
    public void setGold(int gold) {
        if (gold >= 0) {
            this.gold = gold;
        }
    }

    /**
     * @return Character's Gold Currency
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * 
     * @param xp Character's Current XP
     */
    public void setXP(int xp) {
        if (xp >= 0) {
            this.xp = xp;
        }
    }

    /**
     * 
     * @return Character's Current XP
     */
    public int getXP() {
        return this.xp;
    }

    /**
     * 
     * @param hp Character's Current Hit Points
     */
    public void setHP(int hp) {
        if (hp >= 0) {
            this.hp = hp;
        }
    }

    /**
     * 
     * @return Character's Current Hit Points
     */
    public int getHP() {
        return this.hp;
    }

    /**
     * 
     * @param ac Character's Armor Class
     */
    public void setAC(int ac) {
        if (ac >= 0) {
            this.ac = ac;
        }
    }

    /**
     * 
     * @return Character's Armor Class
     */
    public int getAC() {
        return this.ac;
    }

    /**
     * 
     * @param name Character's Name
     */
    public void setName(String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
        }
    }

    /**
     * 
     * @return Character's Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Notice this is Class Name, not class ...
     * @param s Character's Class Name 
     */
    public void setClassName(String className) {
        if (className != null && className.length() > 0) {
            this.className = className;
        }
    }

    /**
     * 
     * @return Character's Class Name
     */
    public String getClassName() {
        return this.className;
    }

    /**
     * 
     * @param alignment Character's Alignment
     */
    public void setAlignment(String alignment) {
        if (alignment != null && alignment.length() > 0) {
            this.alignment = alignment;
        }
    }

    /**
     * 
     * @return Character's Alignment
     */
    public String getAlignment() {
        return this.alignment;
    }

    /**
     * 
     * @param weapon1 Character's First Weapon
     */
    public void setWeapon1(Weapon weapon1) {
        this.weapon1 = weapon1;
    }

    /**
     * 
     * @return Character's First Weapon
     */
    public Weapon getWeapon1() {
        return this.weapon1;
    }

    /**
     * 
     * @param weapon2 Character's Second Weapon
     */
    public void setWeapon2(Weapon weapon2) {
        this.weapon2 = weapon2;
    }

    /**
     * 
     * @return Character's Second Weapon
     */
    public Weapon getWeapon2() {
        return this.weapon2;
    }

    /**
     * 
     * @param gc An allied character to assist
     */
    public abstract void assist(GameCharacter gc);

    /**
     * 
     * @param gc An opposed character to attack
     * @return true if the attack is successful
     */
    public abstract boolean attack(GameCharacter gc);

    public abstract String toString();

    public boolean equals(Object o) {
        boolean varEquals, strEquals, wepEquals;
        varEquals = false;
        strEquals = false;
        wepEquals = false;
        
        if (o instanceof GameCharacter) {
            GameCharacter gc = (GameCharacter) o;

            varEquals = this.gold == gc.gold && this.xp == gc.xp && this.hp == gc.xp && this.ac == gc.ac;

            strEquals = this.name.equals(gc.name) && this.className.equals(gc.className)
                    && this.alignment.equals(gc.alignment);

            wepEquals = (this.weapon1.equals(gc.weapon1) && this.weapon2.equals(gc.weapon2))
                    || (this.weapon1.equals(gc.weapon2) && this.weapon2.equals(gc.weapon1));

        }
        return varEquals && strEquals && wepEquals;
    }
}