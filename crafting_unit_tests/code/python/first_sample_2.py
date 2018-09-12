from django.test import TestCase
from mock import patch
from myapp.models import MyModel

class MyModelTestCase(TestCase):

    def setUp(self):
        super(MyModelTestCase, self).setUp()
        patcher_api_call = patch('internal_api.api_call')
        self.mock_api_call = patcher_api_call.start()
        self.addCleanup(patcher_api_call.stop)

    def test_api_call(self):
        self.mock_api_call.return_value = 1
        MyModel.do_api_call()
        self.assertEqual(MyModel.api_value, 1)
