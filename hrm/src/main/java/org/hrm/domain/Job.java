package org.hrm.domain;

public class Job {

	private Integer id;
	private String name; //Ö°Î»Ãû³Æ
	private String remark; //ÏêÏ¸ÃèÊö
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
	
}
