package com.example.experi.enums;

public enum FamilyRoleEnum {

    /**
     * 配偶
     */
    SPOUSE("配偶",0),
    /**
     *父亲
     */
    FATHER("父亲",1),
    /**
     *母亲"
     */
    MOTHER("母亲",2),
    /**
     *配偶父亲
     */
    SPOUSE_FATHER("配偶父亲",3),
    /**
     *配偶母亲
     */
    SPOUSE_MOTHER("配偶母亲",4),
    /**
     *孩子
     */
    CHILDRED("孩子",5),

    /**
     *本人
     */
    SELF("本人",6);


    private String roleName;

    private int roleType;


    FamilyRoleEnum(String roleName, int roleType){
        this.roleName = roleName;
        this.roleType =roleType;
    }

    public static String getName(int roleType){
        for(FamilyRoleEnum item: FamilyRoleEnum.values()){
            if(item.getRoleType() == roleType){
                return item.getRoleName();
            }
        }
        return "";
    }

    public static Integer getType(String roleName){
        for(FamilyRoleEnum item: FamilyRoleEnum.values()){
            if(item.getRoleName().equalsIgnoreCase(roleName)){
                return item.getRoleType();
            }
        }
        return null;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getRoleType() {
        return roleType;
    }


}
