package ca.uwo.csd.cs2212.team09;

import java.io.Serializable;

public class AccAchievement implements Serializable {

    private boolean Daily;
    private boolean Lifetime;
    private boolean tier1 = false;
    private boolean tier2 = false;
    private boolean tier3 = false;



    public AccAchievement(){

    }


    public boolean isDaily() {return Daily;}

    public void setDaily(boolean daily) {Daily = daily;}

    public boolean isLifetime() {return Lifetime;}

    public void setLifetime(boolean lifetime) {Lifetime = lifetime;}

    public boolean isTier3() {
        return tier3;
    }

    public void setTier3(boolean tier3) {
        this.tier3 = tier3;
    }

    public boolean isTier2() {
        return tier2;
    }

    public void setTier2(boolean tier2) {
        this.tier2 = tier2;
    }

    public boolean isTier1() {
        return tier1;
    }

    public void setTier1(boolean tier1) {
        this.tier1 = tier1;
    }


}
