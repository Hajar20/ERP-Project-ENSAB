$(document).ready(function() {
  $('.nav li:first').addClass('active');

  const showSection = function showSection(section, isAnimate) {
    const direction = section.replace(/#/, ''),
      reqSection = $('.section').filter('[data-section="' + direction + '"]'),
      reqSectionPos = reqSection.offset().top - 0;

    if (isAnimate) {
      $('body, html').animate({
          scrollTop: reqSectionPos
        },
        50);
    } else {
      $('body, html').scrollTop(reqSectionPos);
    }

  };

  const checkSection = function checkSection() {
    $('.section').each(function () {
      const $this = $(this),
        topEdge = $this.offset().top - 80,
        bottomEdge = topEdge + $this.height(),
        wScroll = $(window).scrollTop();
      if (topEdge < wScroll && bottomEdge > wScroll) {
        const currentId = $this.data('section'),
          reqLink = $('a').filter('[href*=\\#' + currentId + ']');
        reqLink.closest('li').addClass('active').siblings().removeClass('active');
      }
    });
  };

  $('.main-menu, .scroll-to-section').on('click', 'a', function (e) {
    if($(e.target).hasClass('external')) {
      return;
    }
    e.preventDefault();
    $('#menu').removeClass('active');
    showSection($(this).attr('href'), true);
  });

  $(window).scroll(function () {
    checkSection();
  });
});
