COMMON_STYLES = $(wildcard ../common/styles/*.sty)
COMMON_FONTFILES = $(wildcard ../common/fonts/*.ttf)
COMMON_IMAGES = $(wildcard ../common/images/*)

LOCAL_STYLES = $(patsubst ../common/%,common/%,$(COMMON_STYLES))
LOCAL_FONTFILES = $(patsubst ../common/%,common/%,$(COMMON_FONTFILES))
LOCAL_IMAGES = $(patsubst %.svg,%.pdf,$(wildcard images/*.svg))
LOCAL_COMMON_IMAGES = $(patsubst ../common/%,common/%,$(COMMON_IMAGES))

LANGUAGES = $(patsubst code/%,%,$(wildcard code/*))
SLIDES = $(patsubst %,slides-%.tex,$(LANGUAGES))
SLIDES_WITH_NOTES = $(patsubst %,slides-%-with-notes.tex,$(LANGUAGES))
TEXFILES = $(SLIDES) $(SLIDES_WITH_NOTES)
PDFFILES = $(patsubst %.tex,%.pdf,$(TEXFILES))

PREPARE_FILES = .latexmkrc $(TEXFILES) $(LOCAL_STYLES) $(LOCAL_FONTFILES) $(LOCAL_COMMON_IMAGES)


.PHONY: all clean prepare

all: prepare $(PDFFILES)

clean:
	@latexmk -C -silent
	@rm -rf _minted-* common $(LOCAL_IMAGES)

prepare: $(PREPARE_FILES) $(LOCAL_IMAGES)

.latexmkrc: ../common/.latexmkrc
	@cp $< $@

%.sty: ../common/styles/%.sty
	@cp $< $@

%.tex: ../common/tex/%.tex
	@cp $< $@

%.pdf: %.tex $(LOCAL_STYLES)
	@latexmk -f $<

%.pdf: %.svg
	@inkscape -f $< --export-pdf=$@

common/styles/%.sty: ../common/styles/%.sty
	@mkdir -p common/styles
	@cp $< $@

common/fonts/%.ttf: ../common/fonts/%.ttf
	@mkdir -p common/fonts
	@cp $< $@

common/images/%: ../common/images/%
	@mkdir -p common/images
	@cp $< $@

#find . -name "*.tex" -o -path "./code/*" -o -path "./style/*" |entr make clean pdf
