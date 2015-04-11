/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "lx_message")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "lx_message_sequence")
public class Message extends BaseEntity {

	private static final long serialVersionUID = -5035343536762850722L;

	private String title;

	private String content;

	private String ip;

	private Boolean isDraft;

	private Boolean senderRead;

	private Boolean receiverRead;

	private Boolean senderDelete;

	private Boolean receiverDelete;

	private Member sender;

	private Member receiver;

	private Message forMessage;

	private Set<Message> replyMessages = new HashSet<Message>();

	@Column(nullable = false, updatable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotEmpty
	@Length(max = 1000)
	@Column(nullable = false, updatable = false, length = 1000)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(nullable = false, updatable = false)
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(nullable = false, updatable = false)
	public Boolean getIsDraft() {
		return isDraft;
	}

	public void setIsDraft(Boolean isDraft) {
		this.isDraft = isDraft;
	}

	@Column(nullable = false)
	public Boolean getSenderRead() {
		return senderRead;
	}

	public void setSenderRead(Boolean senderRead) {
		this.senderRead = senderRead;
	}

	@Column(nullable = false)
	public Boolean getReceiverRead() {
		return receiverRead;
	}

	public void setReceiverRead(Boolean receiverRead) {
		this.receiverRead = receiverRead;
	}

	@Column(nullable = false)
	public Boolean getSenderDelete() {
		return senderDelete;
	}

	public void setSenderDelete(Boolean senderDelete) {
		this.senderDelete = senderDelete;
	}

	@Column(nullable = false)
	public Boolean getReceiverDelete() {
		return receiverDelete;
	}

	public void setReceiverDelete(Boolean receiverDelete) {
		this.receiverDelete = receiverDelete;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false)
	public Member getSender() {
		return sender;
	}

	public void setSender(Member sender) {
		this.sender = sender;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false)
	public Member getReceiver() {
		return receiver;
	}

	public void setReceiver(Member receiver) {
		this.receiver = receiver;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false)
	public Message getForMessage() {
		return forMessage;
	}

	public void setForMessage(Message forMessage) {
		this.forMessage = forMessage;
	}

	@OneToMany(mappedBy = "forMessage", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@OrderBy(value = "createDate asc")
	public Set<Message> getReplyMessages() {
		return replyMessages;
	}

	public void setReplyMessages(Set<Message> replyMessages) {
		this.replyMessages = replyMessages;
	}

}