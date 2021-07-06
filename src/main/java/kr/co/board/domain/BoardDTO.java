package kr.co.board.domain;

import java.io.Serializable;

public class BoardDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int num;
	private String writer;
	private String title;
	private String content;
	private int readCnt;
	private String writeDay;
	private int repRoot;
	private int repStep;
	private int repIndent;
	private String id;

	public BoardDTO() {

	}

	public BoardDTO(int num, String writer, String title, String content, int readCnt, String writeDay, int repRoot,
			int repStep, int repIndent, String id) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.readCnt = readCnt;
		this.writeDay = writeDay;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public String getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(String writeDay) {
		this.writeDay = writeDay;
	}

	public int getRepRoot() {
		return repRoot;
	}

	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}

	public int getRepStep() {
		return repStep;
	}

	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}

	public int getRepIndent() {
		return repIndent;
	}

	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardDTO other = (BoardDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", readCnt=" + readCnt + ", writeDay=" + writeDay + ", repRoot=" + repRoot + ", repStep=" + repStep
				+ ", repIndent=" + repIndent + ", id=" + id + "]";
	}

}
