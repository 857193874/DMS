package bean;

public class Domitory {
	 private Integer domitoryId;

	    private Integer domitoryBuildingid;

	    private String domitoryName;

	    private String domitoryType;

	    private String domitoryNumber;

	    private String domitoryTel;

	    public Integer getDomitoryId() {
	        return domitoryId;
	    }

	    public void setDomitoryId(Integer domitoryId) {
	        this.domitoryId = domitoryId;
	    }

	    public Integer getDomitoryBuildingid() {
	        return domitoryBuildingid;
	    }

	    public void setDomitoryBuildingid(Integer domitoryBuildingid) {
	        this.domitoryBuildingid = domitoryBuildingid;
	    }

	    public String getDomitoryName() {
	        return domitoryName;
	    }

	    public void setDomitoryName(String domitoryName) {
	        this.domitoryName = domitoryName == null ? null : domitoryName.trim();
	    }

	    public String getDomitoryType() {
	        return domitoryType;
	    }

	    public void setDomitoryType(String domitoryType) {
	        this.domitoryType = domitoryType == null ? null : domitoryType.trim();
	    }

	    public String getDomitoryNumber() {
	        return domitoryNumber;
	    }

	    public void setDomitoryNumber(String domitoryNumber) {
	        this.domitoryNumber = domitoryNumber == null ? null : domitoryNumber.trim();
	    }

	    public String getDomitoryTel() {
	        return domitoryTel;
	    }

	    public void setDomitoryTel(String domitoryTel) {
	        this.domitoryTel = domitoryTel == null ? null : domitoryTel.trim();
	    }
}
