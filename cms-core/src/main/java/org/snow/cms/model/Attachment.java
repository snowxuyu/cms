package org.snow.cms.model;

public class Attachment {
	private int id;
	private String oldName;
	private String newName;
	private String type;
	private String suffix;
	private long size;
	private int isIndexPic;
	private int isImg;
	private int isAttach;
	private Topic topic;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOldName() {
		return this.oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getNewName() {
		return this.newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public long getSize() {
		return this.size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public int getIsIndexPic() {
		return this.isIndexPic;
	}

	public void setIsIndexPic(int isIndexPic) {
		this.isIndexPic = isIndexPic;
	}

	public int getIsImg() {
		return this.isImg;
	}

	public void setIsImg(int isImg) {
		this.isImg = isImg;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public int getIsAttach() {
		return this.isAttach;
	}

	public void setIsAttach(int isAttach) {
		this.isAttach = isAttach;
	}

	public Attachment() {
	}

	public Attachment(int id, String newName, String oldName, String type,
			String suffix, long size, int isIndexPic, int isImg, int isAttach,
			int tid) {
		this.id = id;
		this.newName = newName;
		this.oldName = oldName;
		this.type = type;
		this.suffix = suffix;
		this.size = size;
		this.isIndexPic = isIndexPic;
		this.isImg = isImg;
		this.isAttach = isAttach;
		this.topic = new Topic();
		this.topic.setId(tid);
	}

	public Attachment(int id, String newName, String oldName, String type,
			String suffix, long size, int isIndexPic, int isImg, int isAttach) {
		this.id = id;
		this.newName = newName;
		this.oldName = oldName;
		this.type = type;
		this.suffix = suffix;
		this.size = size;
		this.isIndexPic = isIndexPic;
		this.isImg = isImg;
		this.isAttach = isAttach;
		this.topic = new Topic();
	}
}
