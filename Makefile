SUBDIRS = crafting_unit_tests \
					crafting_with_solid_principles

.PHONY: $(SUBDIRS) all common clean

all:
	@for dir in $(SUBDIRS); do \
		$(MAKE) -C $$dir $@ ; \
	done

common:
	@for dir in $(SUBDIRS); do \
		$(MAKE) -C $$dir $@ ; \
	done

clean:
	@for dir in $(SUBDIRS); do \
		$(MAKE) -C $$dir $@ ; \
	done
