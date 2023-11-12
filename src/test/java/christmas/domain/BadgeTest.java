package christmas.domain;

import static christmas.config.BadgeList.SANTA;
import static christmas.config.BadgeList.STAR;
import static christmas.config.BadgeList.TREE;
import static christmas.config.message.ResultMessage.NONE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BadgeTest {

	private Badge badge;

	@Test
	@DisplayName("구매금액이 5,000원 이하일 경우 뱃지 없음")
	void getBadge_None() {
		badge = new Badge(4_200);

		String result = badge.getBadge();

		Assertions.assertThat(result).isEqualTo(NONE.getMessage());
	}

	@DisplayName("구매금액이 5,000원 이상 10,000 미만일 경우 뱃지는 별")
	@ParameterizedTest
	@ValueSource(ints = {5_000, 5_500, 9_800})
	void getBadge_Star(int discountAmount) {
		badge = new Badge(discountAmount);

		String result = badge.getBadge();

		Assertions.assertThat(result).isEqualTo(STAR.getName());
	}

	@DisplayName("구매금액이 10,000원 이상 20,000 미만일 경우 뱃지는 트리")
	@ParameterizedTest
	@ValueSource(ints = {10_000, 12_500, 19_800})
	void getBadge_Tree(int discountAmount) {
		badge = new Badge(discountAmount);

		String result = badge.getBadge();

		Assertions.assertThat(result).isEqualTo(TREE.getName());
	}

	@DisplayName("구매금액이 20,000 이상일 경우 뱃지는 산타")
	@ParameterizedTest
	@ValueSource(ints = {20_000, 24_500, 100_800})
	void getBadge_Santa(int discountAmount) {
		badge = new Badge(discountAmount);

		String result = badge.getBadge();

		Assertions.assertThat(result).isEqualTo(SANTA.getName());
	}
}