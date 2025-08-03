package BookMyshow.model;

import BookMyshow.Franchise;

import java.util.List;

public class Theater
{
    private String Id;
    private String region;
    private List<Screen> screenList;
    private Franchise franchise;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }
}
