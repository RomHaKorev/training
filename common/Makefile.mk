COMMON_STYLES = $(wildcard ../common/styles/*.sty)
COMMON_FONTFILES = $(wildcard ../common/fonts/*.ttf)

LOCAL_STYLES = $(patsubst ../common/styles/%,%,$(COMMON_STYLES))
LOCAL_FONTFILES = $(patsubst ../common/%,%,$(COMMON_FONTFILES))
LOCAL_IMAGES = $(patsubst %.svg,%.pdf,$(wildcard images/*.svg))

LANGUAGES = $(patsubst code/%,%,$(wildcard code/*))
SLIDES = $(patsubst %,slides-%.tex,$(LANGUAGES))
SLIDES_WITH_NOTES = $(patsubst %,slides-%-with-notes.tex,$(LANGUAGES))
TEXFILES = $(SLIDES) $(SLIDES_WITH_NOTES)
PDFFILES = $(patsubst %.tex,%.pdf,$(TEXFILES))

CLEAN_FILES = .latexmkrc $(TEXFILES) $(LOCAL_STYLES) $(LOCAL_FONTFILES)


.PHONY: all clean images common

all: images common $(PDFFILES)
	@echo $(TEXFILES)

clean:
	@latexmk -C -silent
	@rm -rf _minted-* fonts $(LOCAL_IMAGES)

images: $(LOCAL_IMAGES)

common: $(CLEAN_FILES)

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
