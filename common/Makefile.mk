COMMON_TEXFILES = $(wildcard ../common/tex/*.tex)
COMMON_STYLES = $(wildcard ../common/styles/*.sty)
COMMON_FONTFILES = $(wildcard ../common/fonts/*.ttf)

LOCAL_TEXFILES = $(patsubst ../common/tex/%,%,$(COMMON_TEXFILES))
LOCAL_STYLES = $(patsubst ../common/styles/%,%,$(COMMON_STYLES))
LOCAL_FONTFILES = $(patsubst ../common/%,%,$(COMMON_FONTFILES))
LOCAL_PDFFILES = $(patsubst %.tex,%.pdf,$(LOCAL_TEXFILES))
LOCAL_IMAGES = $(patsubst %.svg,%.pdf,$(wildcard images/*.svg))
LOCAL_FILES = .latexmkrc $(LOCAL_TEXFILES) $(LOCAL_STYLES) $(LOCAL_FONTFILES)


.PHONY: all clean images common

all: images common $(LOCAL_PDFFILES)

clean:
	@latexmk -C -silent
	@rm -rf _minted-* fonts $(LOCAL_IMAGES)

images: $(LOCAL_IMAGES)

common: $(LOCAL_FILES)

.latexmkrc: ../common/.latexmkrc
	@cp $< $@

%.sty: ../common/styles/%.sty
	@cp $< $@

%.tex: ../common/tex/%.tex
	@cp $< $@

%.pdf: %.tex
	@latexmk -f $<

%.pdf: %.svg
	@inkscape -f $< --export-pdf=$@

fonts/%.ttf: ../common/fonts/%.ttf
	@mkdir -p fonts
	@cp $< $@

#find . -name "*.tex" -o -path "./code/*" -o -path "./style/*" |entr make clean pdf
