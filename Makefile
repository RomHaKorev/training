SUBDIRS = crafting_unit_tests \
					crafting_with_solid_principles

.PHONY: $(SUBDIRS) all clean prepare

all:
	@for dir in $(SUBDIRS); do \
		$(MAKE) -C $$dir $@ ; \
	done

prepare:
	@for dir in $(SUBDIRS); do \
		$(MAKE) -C $$dir $@ ; \
	done

clean:
	@for dir in $(SUBDIRS); do \
		$(MAKE) -C $$dir $@ ; \
	done
