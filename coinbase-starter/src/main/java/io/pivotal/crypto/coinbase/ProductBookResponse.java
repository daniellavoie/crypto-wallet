package io.pivotal.crypto.coinbase;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductBookResponse {
	private final long sequence;
	private final List<double[]> bids;
	private final List<double[]> asks;

	@JsonCreator
	public ProductBookResponse(@JsonProperty("sequence") long sequence, @JsonProperty("bids") List<double[]> bids,
			@JsonProperty("asks") List<double[]> asks) {
		this.sequence = sequence;
		this.bids = bids;
		this.asks = asks;
	}

	public long getSequence() {
		return sequence;
	}

	public List<double[]> getBids() {
		return bids;
	}

	public List<double[]> getAsks() {
		return asks;
	}
}
