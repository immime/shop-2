
package com.lingxiang2014.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lx_sn")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "lx_sn_sequence")
public class Sn extends BaseEntity {

	private static final long serialVersionUID = -2330598144835706164L;

	public enum Type {

		product,

		order,

		payment,

		refunds,

		shipping,

		returns
	}

	private Type type;

	private Long lastValue;

	@Column(nullable = false, updatable = false, unique = true)
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Column(nullable = false)
	public Long getLastValue() {
		return lastValue;
	}

	public void setLastValue(Long lastValue) {
		this.lastValue = lastValue;
	}

}