package pl.askawinska.zabajour.dto;

public class ResponseDto {
	private String original;
	private String translated;

	public String getOriginal() {
		return original;
	}

	public String getTranslated() {
		return translated;
	}

	public void setTranslated(final String translated) {
		this.translated = translated;
	}

	public static class Builder {
		private String original;
		private String translated;

		public Builder setTranslated(final String translated) {
			this.translated = translated;
			return this;
		}

		public Builder setOriginal(final String original) {
			this.original = original;
			return this;
		}

		public ResponseDto build() {
			ResponseDto response = new ResponseDto();
			response.translated = this.translated;
			response.original = this.original;
			return response;
		}
	}
}
